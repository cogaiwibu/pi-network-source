# Decompiling the PI network source code

- java/: The Android Java code
- react-native/: The react-native bundle
- webview/: The Javascript code on PI webview

# Ứng dụng PI network thực sự “đào” PI như thế nào


Xin chào các bạn!

Dạo gần đây cư dân mạng Việt Nam đang đổ xô vào trào lưu đào tiền ảo PI network. Các diễn đàn về PI hoặc các nhóm PI trên facebook có rất đông đảo người tham gia. Từ các em gái chân dài tới nách, ngực nở, eo thon vô post bài khoe tâm hồn to tròn cho tới các máy bay bà già U50, U70, B52, B86..., đầy đủ cả. Nhiều nhà tiên tri vũ trụ còn khẳng định chắc chắn rằng PI sau này có thể có giá vài trăm đô, thậm chí là vài nghìn đô. Ai ai cũng hừng hực khí thế làm giàu. Với tiêu chí không làm mà vẫn có ăn, tội gì không thử. Cho nên mình đã reverse app PI ra xem có thực sự là không làm mà vẫn có ăn thiệt không, hay chỉ là ăn đầu bu..i, ăn c..t thôi, giống như một vị thánh nhân nào đó đã từng nói.

![1](https://user-images.githubusercontent.com/11779953/112744474-97ed2900-8fca-11eb-84e8-bcd0da1d3c7f.jpeg)

## Phần 1: Lấy file APK và dịch ngược source code

Mình tải app PI từ link https://play.google.com/store/apps/details?id=com.blockchainvault . Sở dĩ mình chọn làm trên Android vì hệ điều hành này có mã nguồn mở nên có nhiều tool và dễ làm hơn iOS.

Mình dùng tool ADB (Android Debug Bridge) để lấy APK về máy. Hoặc các bạn cũng có thể lên một số trang get link APK như apkpure để lấy về.

Để decompile được source code, mình dùng tool JADX https://github.com/skylot/jadx. 

Tất cả source code (bao gồm code Java, phần react-native và phần webview) mình đã decompile và để trên github này

https://github.com/cogaiwibu/pi-network-source


## Phần 2: Phân tích source code

Vì app Pi network không sử dụng Proguard/R8 để obfuscate code, nên source code rất dễ đọc. Hơn nữa app này viết bằng React Native nên nội dung code nằm hết trong assets/index.android.bundle. Phần Java code không có gì đặc biệt ngoại trừ file MainApplication và một số library dùng để gắn quảng cáo.

![2](https://user-images.githubusercontent.com/11779953/112744507-e5699600-8fca-11eb-95db-3af4130d9488.png)


Mình phát hiện ra là PI network gắn rất nhiều loại quảng cáo khác nhau, bao gồm Admob, IronSource, Facebook audience network

Admob
![3](https://user-images.githubusercontent.com/11779953/112744515-fd411a00-8fca-11eb-9fc0-f2e2586fec40.png)

Facebook audience network
![4](https://user-images.githubusercontent.com/11779953/112744537-177af800-8fcb-11eb-8536-5824c7a83cda.png)

IronSource
![5](https://user-images.githubusercontent.com/11779953/112744543-282b6e00-8fcb-11eb-8d92-a6aa3cfc8951.png)

Ngoài ra Pi network sử dụng thêm library RN device info để collect thông tin thiết bị của user https://github.com/react-native-device-info/react-native-device-info

![6](https://user-images.githubusercontent.com/11779953/112744582-83f5f700-8fcb-11eb-8e83-4a261cb90e5d.png)

## Phần 3: Reversing the React Native code

Phần react native code nằm trong assets/index.android.bundle. Code này chủ yếu là collect thông tin device và load quảng cáo

![7](https://user-images.githubusercontent.com/11779953/112744595-9c661180-8fcb-11eb-973a-92e203640f04.png)

![8](https://user-images.githubusercontent.com/11779953/112744599-ad168780-8fcb-11eb-9ce5-5f23963f9c73.png)

## Phần 4: Man-in-the-middle the APIs

Thực chất ứng dụng PI network chỉ là 1 cái web, dùng webview của Android để hiển thị lên. Do đó thay vì dùng Burp Suite hoặc MITM phải setup proxy tốn thời gian thì mình dùng Chrome để debug luôn cái PI webview cho nhanh

Để debug được webview của app PI thì cần chèn thêm dòng 

**WebView.setWebContentsDebuggingEnabled(true)**

vào file DEX của app PI. 

Có nhiều các để làm việc này, dùng Frida hoặc repack lại app hoặc dùng Xposed.

Mình sử dụng Xposed. Xposed là một framework cài vô Android device, can thiệp vào Zygote process để hook vào máy ảo Android Runtime. Mình load module này của Xposed để force cho webview luôn bật debug.

https://github.com/feix760/WebViewDebugHook

Sau khi debug được webview của app PI, thì cách làm của PI network đã lộ ra khá rõ

Dùng Xposed để bật chrome remote debug
![9](https://user-images.githubusercontent.com/11779953/112744628-ef3fc900-8fcb-11eb-833a-4e72aa16b4d3.png)

![10](https://user-images.githubusercontent.com/11779953/112744634-fff03f00-8fcb-11eb-861c-2c4f4af9b593.png)

![11](https://user-images.githubusercontent.com/11779953/112744638-1bf3e080-8fcc-11eb-9e49-840d1840138d.png)

![12](https://user-images.githubusercontent.com/11779953/112744639-201ffe00-8fcc-11eb-8b7c-c880aee066bf.png)

Thực chất PI chả sử dụng công nghệ Blockchain hay gì đặc biệt cả, tất cả chỉ là gọi API và lưu data trên backend của họ mà thôi

Nhập SĐT: Gọi API https://socialchain.app/api/users/phone để kiểm tra SDT đã đăng kí hay chưa

Nhập mật khẩu: Gọi API https://socialchain.app/api/setup_password

Sign-in: Gọi API https://socialchain.app/api/password_sign_in

Nhập referral code: gọi API https://socialchain.app/api/referrals/recover

Setup profile: gọi API https://socialchain.app/api/profile . Chỗ này PI có sử dụng Google invisibile reCAPTCHA để chống bot, ngăn chặn register hàng loạt để cheat app. Tuy nhiên reCAPTCHA này vẫn bypass được bằng cách dùng Speech Recognition, mình đã buff thêm vài chục ngàn acc clone để tăng tốc độ đào PI cho mình

![13](https://user-images.githubusercontent.com/11779953/112744652-3cbc3600-8fcc-11eb-8f08-5ff22281c9d7.jpeg)

Vì không dùng blockchain nên rất khó có thể nói PI có giá trị thực tế gì hay không. Khác hẳn với Bitcoin, giao dịch phải được xác thực bởi tất cả những người trong mạng lưới blockchain, PI network không làm vậy mà họ chỉ lưu data ở server tập trung của họ, nên việc sửa data này rất dễ dàng (và dĩ nhiên tính minh bạch là một dấu hỏi rất lớn)

## Phần 5: Đào PI như thế nào

Thực chất việc đào PI chỉ là gọi API https://socialchain.app/api/proof_of_presences

![14](https://user-images.githubusercontent.com/11779953/112744671-5d848b80-8fcc-11eb-9b15-046952d16ad2.png)

![15](https://user-images.githubusercontent.com/11779953/112744673-5fe6e580-8fcc-11eb-9e26-8bad8d0982d6.png)

Hằng ngày khi user vào app, PI sẽ gọi API *proof_of_presences* và đánh dấu là user đó active. Sau 24h thì app PI sẽ đánh dấu user là inactive. Sau khi nhấn vào tia sét thì app PI lại gọi *proof_of_presences* và lại active. Tất cả những số PI đang chạy mà các bạn thấy trên màn hình không phải là app PI đang đào coin hay chạy blockchain gì cả mà chỉ là họ set interval trong Javascript code để thay đổi giá trị PI trên UI mà thôi

Thực chất đào PI chỉ là dùng Javascript timer
![16](https://user-images.githubusercontent.com/11779953/112744697-97559200-8fcc-11eb-9d6d-6c43819cb79c.png)


Thêm một điều nữa là app PI chuẩn bị rất kỹ phần hiển thị quảng cáo để kiếm tiền, có hẳn các đoạn code logic để control việc có bật quảng cáo hay không

![17](https://user-images.githubusercontent.com/11779953/112744714-afc5ac80-8fcc-11eb-8a5e-8d53e19d4e66.png)
![18](https://user-images.githubusercontent.com/11779953/112744718-b48a6080-8fcc-11eb-9635-668ea16904ca.png)

Họ còn xử lý riêng cho việc bật quảng cáo tại thị trường Trung Quốc, vì ở Trung Quốc không có google play service nên không dùng admob được
![19](https://user-images.githubusercontent.com/11779953/112744728-c7049a00-8fcc-11eb-89eb-dcfc572347cb.png)

## Phần 6: Xác thực SMS
Vì PI network chủ yếu là được viết ra để kiếm tiền quảng cáo cho nên họ cũng không có tiền để gửi SMS xác thực đến cho người dùng giống như các ứng dụng khác. Thay vào đó người dùng phải chủ động gửi SMS đến SĐT của họ để xác thực (biểu hiện của sự lươn lẹo)

## Phần 7: Tổng kết

Theo nhìn nhận của mình, app PI thực chất chỉ là một ứng dụng gọi API và lưu dữ liệu trên backend thông thường, không dùng blockchain, không có giá trị xác thực giao dịch như bitcoin hay các loại tiền điện tử khác. Ứng dụng PI thực chất chỉ để scam người dùng kiếm tiền quảng cáo mà thôi.

Còn việc PI có giá trị thật trên thị trường hay không thì còn tùy thuộc vào số lượng người tin tưởng nó. Tuy nhiên các bạn đừng nên upload hình ảnh cá nhân, thông tin CMND hay hộ chiếu lên app PI nhé. Biết đâu một ngày đẹp trời thông tin cá nhân của các bạn sẽ bị PI network đem đi bán thì hậu quả vô cùng khó lường.


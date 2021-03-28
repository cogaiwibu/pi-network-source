package com.ironsource.mediationsdk;

/* compiled from: AuctionHandler */
class AuctionConstants {
    static final String AUCTION_REQUEST_BODY_FORMAT = "{\"request\" : \"%1$s\"}";
    static final String AUCTION_RESPONSE_DECOMPRESSION_ERROR_MSG = "Auction decompression error";
    static final String AUCTION_RESPONSE_DECRYPTION_ERROR_MSG = "Auction decryption error";
    static final String AUCTION_RESPONSE_PARSING_ERROR_MSG = "Auction parsing error";
    static final String AUCTION_TIMEOUT_ERROR_MSG = "Connection timed out";
    static final String DEFAULT_AUCTION_FALLBACK_VALUE = "other";
    static final String PARSING_AUCTION_FALLBACK_VALUE = "parsing";
    static final String TRIALS_FAIL_AUCTION_FALLBACK_VALUE = "trials_fail";

    AuctionConstants() {
    }
}

package com.ironsource.environment;

interface ANRListener {
    void onANRHandlerDogGivingUp();

    void onAppNotResponding(ANRError aNRError);
}

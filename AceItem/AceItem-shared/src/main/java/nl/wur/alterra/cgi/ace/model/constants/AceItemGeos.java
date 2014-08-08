package nl.wur.alterra.cgi.ace.model.constants;

public enum AceItemGeos {

    /**
     * Transnational region (stretching across country borders)
     */
     TRANS(true),

    /**
     * National
     */
    NAT(true),


    /**
     * Subnational Regions
     */
    SNA(true),

    /**
     * Local (e.g. city or municipal level)
     */
    LC(true);


    private boolean isRadio = false;

    AceItemGeos(boolean isRadio)
    {
       this.isRadio = isRadio;
    }

    public boolean isRadio()
    {
        return this.isRadio;
    }

}





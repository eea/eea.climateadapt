package nl.wur.alterra.cgi.ace.model.constants;

public enum AceItemGeos {
	
	/**
     * Northern Periphery
     */
	NORTH_PERIPHERY(true),
	
	/**
     * South East Europe
     */
	SE_EUROPE(true),
	
	/**
     * Atlantic Area
     */
	A_AREA(true),
	
	/**
     * North West Europe
     */
	NW_EUROPE(true),
	
	/**
     * Maca
     */
	MAC(true),

	/**
     * North Sea
     */
	NORTH_SEA(true),
	
	/**
     * Indian Ocean Area
     */
	IO_AREA(true),
	
	/**
     * South West Europe
     */
	SW_EUROPE(true),
	
	/**
     * Alpine Space
     */
	AL_SPACE(true),
	
	/**
     * Central Europe
     */
	CE_EUROPE(true),
	
	/**
     * Baltic Sea
     */
	B_SEA(true),
	
	/**
     * Caribbean Area
     */
	CAR(true),
	
	/**
     * Mediterranean
     */
	MED(true),
	
	/**
     * National
     */
	NAT(false),
	

	/**
     * Subnational Regions
     */
	SNA(false),
	
	/**
     * Local
     */
	LC(false);
	
	
	
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





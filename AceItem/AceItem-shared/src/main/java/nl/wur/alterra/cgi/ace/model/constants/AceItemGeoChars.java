package nl.wur.alterra.cgi.ace.model.constants;

/**
 * Geo Characterizations.
 *
 * @author Mohamed
 */
public enum AceItemGeoChars {

    /**
     * Global.
     */
     GLOBAL,

    /**
     * Europe
     */
     EUROPE,

    /**
     * Macro-Transnational region
     */
     MACRO_TRANSNATIONAL_REGION,

    /**
     * Biographical regions
     */
     BIOGRAPHICAL_REGION,

     /**
      * Countries
      */
     COUNTRIES,

    /**
     * Subnational
     */
    SUBNATIONAL,

    /**
     * Cities and Towns
     */
    CITY,

    /*** Région de Bruxelles-Capitale/Brussels Hoofdstedelijk Gewest (BE) ***/
    SUBN_Région_de_Bruxelles_Capit("Région de Bruxelles-Capitale/Brussels Hoofdstedelijk Gewest (BE)"),

    /*** Prov. Antwerpen (BE) ***/
    SUBN_Prov__Antwerpen__BE_("Prov. Antwerpen (BE)"),

    /*** Prov. Limburg (BE) (BE) ***/
    SUBN_Prov__Limburg__BE___BE_("Prov. Limburg (BE) (BE)"),

    /*** Prov. Oost-Vlaanderen (BE) ***/
    SUBN_Prov__Oost_Vlaanderen__BE("Prov. Oost-Vlaanderen (BE)"),

    /*** Prov. Vlaams-Brabant (BE) ***/
    SUBN_Prov__Vlaams_Brabant__BE_("Prov. Vlaams-Brabant (BE)"),

    /*** Prov. West-Vlaanderen (BE) ***/
    SUBN_Prov__West_Vlaanderen__BE("Prov. West-Vlaanderen (BE)"),

    /*** Prov. Brabant Wallon (BE) ***/
    SUBN_Prov__Brabant_Wallon__BE_("Prov. Brabant Wallon (BE)"),

    /*** Prov. Hainaut (BE) ***/
    SUBN_Prov__Hainaut__BE_("Prov. Hainaut (BE)"),

    /*** Prov. Liège (BE) ***/
    SUBN_Prov__Liège__BE_("Prov. Liège (BE)"),

    /*** Prov. Luxembourg (BE) (BE) ***/
    SUBN_Prov__Luxembourg__BE___BE("Prov. Luxembourg (BE) (BE)"),

    /*** Prov. Namur (BE) ***/
    SUBN_Prov__Namur__BE_("Prov. Namur (BE)"),

    /*** Extra-Regio NUTS 2 (BE) ***/
    SUBN_Extra_Regio_NUTS_2__BE_("Extra-Regio NUTS 2 (BE)"),

    /*** Северозападен (Severozapaden) (BG) ***/
    SUBN_Северозападен__Severozapa("Северозападен (Severozapaden) (BG)"),

    /*** Северен централен (Severen tsentralen) (BG) ***/
    SUBN_Северен_централен__Severe("Северен централен (Severen tsentralen) (BG)"),

    /*** Североизточен (Severoiztochen) (BG) ***/
    SUBN_Североизточен__Severoizto("Североизточен (Severoiztochen) (BG)"),

    /*** Югоизточен (Yugoiztochen) (BG) ***/
    SUBN_Югоизточен__Yugoiztochen_("Югоизточен (Yugoiztochen) (BG)"),

    /*** Югозападен (Yugozapaden) (BG) ***/
    SUBN_Югозападен__Yugozapaden__("Югозападен (Yugozapaden) (BG)"),

    /*** Южен централен (Yuzhen tsentralen) (BG) ***/
    SUBN_Южен_централен__Yuzhen_ts("Южен централен (Yuzhen tsentralen) (BG)"),

    /*** Extra-Regio NUTS 2 (BG) ***/
    SUBN_Extra_Regio_NUTS_2__BG_("Extra-Regio NUTS 2 (BG)"),

    /*** Praha (CZ) ***/
    SUBN_Praha__CZ_("Praha (CZ)"),

    /*** Střední Čechy (CZ) ***/
    SUBN_Střední_Čechy__CZ_("Střední Čechy (CZ)"),

    /*** Jihozápad (CZ) ***/
    SUBN_Jihozápad__CZ_("Jihozápad (CZ)"),

    /*** Severozápad (CZ) ***/
    SUBN_Severozápad__CZ_("Severozápad (CZ)"),

    /*** Severovýchod (CZ) ***/
    SUBN_Severovýchod__CZ_("Severovýchod (CZ)"),

    /*** Jihovýchod (CZ) ***/
    SUBN_Jihovýchod__CZ_("Jihovýchod (CZ)"),

    /*** Střední Morava (CZ) ***/
    SUBN_Střední_Morava__CZ_("Střední Morava (CZ)"),

    /*** Moravskoslezsko (CZ) ***/
    SUBN_Moravskoslezsko__CZ_("Moravskoslezsko (CZ)"),

    /*** Extra-Regio NUTS 2 (CZ) ***/
    SUBN_Extra_Regio_NUTS_2__CZ_("Extra-Regio NUTS 2 (CZ)"),

    /*** Hovedstaden (DK) ***/
    SUBN_Hovedstaden__DK_("Hovedstaden (DK)"),

    /*** Sjælland (DK) ***/
    SUBN_Sjælland__DK_("Sjælland (DK)"),

    /*** Syddanmark (DK) ***/
    SUBN_Syddanmark__DK_("Syddanmark (DK)"),

    /*** Midtjylland (DK) ***/
    SUBN_Midtjylland__DK_("Midtjylland (DK)"),

    /*** Nordjylland (DK) ***/
    SUBN_Nordjylland__DK_("Nordjylland (DK)"),

    /*** Extra-Regio NUTS 2 (DK) ***/
    SUBN_Extra_Regio_NUTS_2__DK_("Extra-Regio NUTS 2 (DK)"),

    /*** Stuttgart (DE) ***/
    SUBN_Stuttgart__DE_("Stuttgart (DE)"),

    /*** Karlsruhe (DE) ***/
    SUBN_Karlsruhe__DE_("Karlsruhe (DE)"),

    /*** Freiburg (DE) ***/
    SUBN_Freiburg__DE_("Freiburg (DE)"),

    /*** Tübingen (DE) ***/
    SUBN_Tübingen__DE_("Tübingen (DE)"),

    /*** Oberbayern (DE) ***/
    SUBN_Oberbayern__DE_("Oberbayern (DE)"),

    /*** Niederbayern (DE) ***/
    SUBN_Niederbayern__DE_("Niederbayern (DE)"),

    /*** Oberpfalz (DE) ***/
    SUBN_Oberpfalz__DE_("Oberpfalz (DE)"),

    /*** Oberfranken (DE) ***/
    SUBN_Oberfranken__DE_("Oberfranken (DE)"),

    /*** Mittelfranken (DE) ***/
    SUBN_Mittelfranken__DE_("Mittelfranken (DE)"),

    /*** Unterfranken (DE) ***/
    SUBN_Unterfranken__DE_("Unterfranken (DE)"),

    /*** Schwaben (DE) ***/
    SUBN_Schwaben__DE_("Schwaben (DE)"),

    /*** Berlin (DE) ***/
    SUBN_Berlin__DE_("Berlin (DE)"),

    /*** Brandenburg (DE) ***/
    SUBN_Brandenburg__DE_("Brandenburg (DE)"),

    /*** Bremen (DE) ***/
    SUBN_Bremen__DE_("Bremen (DE)"),

    /*** Hamburg (DE) ***/
    SUBN_Hamburg__DE_("Hamburg (DE)"),

    /*** Darmstadt (DE) ***/
    SUBN_Darmstadt__DE_("Darmstadt (DE)"),

    /*** Gießen (DE) ***/
    SUBN_Gießen__DE_("Gießen (DE)"),

    /*** Kassel (DE) ***/
    SUBN_Kassel__DE_("Kassel (DE)"),

    /*** Mecklenburg-Vorpommern (DE) ***/
    SUBN_Mecklenburg_Vorpommern__D("Mecklenburg-Vorpommern (DE)"),

    /*** Braunschweig (DE) ***/
    SUBN_Braunschweig__DE_("Braunschweig (DE)"),

    /*** Hannover (DE) ***/
    SUBN_Hannover__DE_("Hannover (DE)"),

    /*** Lüneburg (DE) ***/
    SUBN_Lüneburg__DE_("Lüneburg (DE)"),

    /*** Weser-Ems (DE) ***/
    SUBN_Weser_Ems__DE_("Weser-Ems (DE)"),

    /*** Düsseldorf (DE) ***/
    SUBN_Düsseldorf__DE_("Düsseldorf (DE)"),

    /*** Köln (DE) ***/
    SUBN_Köln__DE_("Köln (DE)"),

    /*** Münster (DE) ***/
    SUBN_Münster__DE_("Münster (DE)"),

    /*** Detmold (DE) ***/
    SUBN_Detmold__DE_("Detmold (DE)"),

    /*** Arnsberg (DE) ***/
    SUBN_Arnsberg__DE_("Arnsberg (DE)"),

    /*** Koblenz (DE) ***/
    SUBN_Koblenz__DE_("Koblenz (DE)"),

    /*** Trier (DE) ***/
    SUBN_Trier__DE_("Trier (DE)"),

    /*** Rheinhessen-Pfalz (DE) ***/
    SUBN_Rheinhessen_Pfalz__DE_("Rheinhessen-Pfalz (DE)"),

    /*** Saarland (DE) ***/
    SUBN_Saarland__DE_("Saarland (DE)"),

    /*** Dresden (DE) ***/
    SUBN_Dresden__DE_("Dresden (DE)"),

    /*** Chemnitz (DE) ***/
    SUBN_Chemnitz__DE_("Chemnitz (DE)"),

    /*** Leipzig (DE) ***/
    SUBN_Leipzig__DE_("Leipzig (DE)"),

    /*** Sachsen-Anhalt (DE) ***/
    SUBN_Sachsen_Anhalt__DE_("Sachsen-Anhalt (DE)"),

    /*** Schleswig-Holstein (DE) ***/
    SUBN_Schleswig_Holstein__DE_("Schleswig-Holstein (DE)"),

    /*** Thüringen (DE) ***/
    SUBN_Thüringen__DE_("Thüringen (DE)"),

    /*** Extra-Regio NUTS 2 (DE) ***/
    SUBN_Extra_Regio_NUTS_2__DE_("Extra-Regio NUTS 2 (DE)"),

    /*** Eesti (EE) ***/
    SUBN_Eesti__EE_("Eesti (EE)"),

    /*** Extra-Regio NUTS 2 (EE) ***/
    SUBN_Extra_Regio_NUTS_2__EE_("Extra-Regio NUTS 2 (EE)"),

    /*** Border, Midland and Western (IE) ***/
    SUBN_Border__Midland_and_Weste("Border, Midland and Western (IE)"),

    /*** Southern and Eastern (IE) ***/
    SUBN_Southern_and_Eastern__IE_("Southern and Eastern (IE)"),

    /*** Extra-Regio NUTS 2 (IE) ***/
    SUBN_Extra_Regio_NUTS_2__IE_("Extra-Regio NUTS 2 (IE)"),

    /*** Aνατολική Μακεδονία, Θράκη (Anatoliki Makedonia, Thraki) (EL) ***/
    SUBN_Aνατολική_Μακεδονία__Θράκ("Aνατολική Μακεδονία, Θράκη (Anatoliki Makedonia, Thraki) (EL)"),

    /*** Κεντρική Μακεδονία (Kentriki Makedonia) (EL) ***/
    SUBN_Κεντρική_Μακεδονία__Kentr("Κεντρική Μακεδονία (Kentriki Makedonia) (EL)"),

    /*** Δυτική Μακεδονία (Dytiki Makedonia) (EL) ***/
    SUBN_Δυτική_Μακεδονία__Dytiki_("Δυτική Μακεδονία (Dytiki Makedonia) (EL)"),

    /*** Θεσσαλία (Thessalia) (EL) ***/
    SUBN_Θεσσαλία__Thessalia___EL_("Θεσσαλία (Thessalia) (EL)"),

    /*** Ήπειρος (Ipeiros) (EL) ***/
    SUBN_Ήπειρος__Ipeiros___EL_("Ήπειρος (Ipeiros) (EL)"),

    /*** Ιόνια Νησιά (Ionia Nisia) (EL) ***/
    SUBN_Ιόνια_Νησιά__Ionia_Nisia_("Ιόνια Νησιά (Ionia Nisia) (EL)"),

    /*** Δυτική Ελλάδα (Dytiki Ellada) (EL) ***/
    SUBN_Δυτική_Ελλάδα__Dytiki_Ell("Δυτική Ελλάδα (Dytiki Ellada) (EL)"),

    /*** Στερεά Ελλάδα (Sterea Ellada) (EL) ***/
    SUBN_Στερεά_Ελλάδα__Sterea_Ell("Στερεά Ελλάδα (Sterea Ellada) (EL)"),

    /*** Πελοπόννησος (Peloponnisos) (EL) ***/
    SUBN_Πελοπόννησος__Peloponniso("Πελοπόννησος (Peloponnisos) (EL)"),

    /*** Aττική (Attiki) (EL) ***/
    SUBN_Aττική__Attiki___EL_("Aττική (Attiki) (EL)"),

    /*** Βόρειο Αιγαίο (Voreio Aigaio) (EL) ***/
    SUBN_Βόρειο_Αιγαίο__Voreio_Aig("Βόρειο Αιγαίο (Voreio Aigaio) (EL)"),

    /*** Νότιο Αιγαίο (Notio Aigaio) (EL) ***/
    SUBN_Νότιο_Αιγαίο__Notio_Aigai("Νότιο Αιγαίο (Notio Aigaio) (EL)"),

    /*** Κρήτη (Kriti) (EL) ***/
    SUBN_Κρήτη__Kriti___EL_("Κρήτη (Kriti) (EL)"),

    /*** Extra-Regio NUTS 2 (EL) ***/
    SUBN_Extra_Regio_NUTS_2__EL_("Extra-Regio NUTS 2 (EL)"),

    /*** Galicia (ES) ***/
    SUBN_Galicia__ES_("Galicia (ES)"),

    /*** Principado de Asturias (ES) ***/
    SUBN_Principado_de_Asturias__E("Principado de Asturias (ES)"),

    /*** Cantabria (ES) ***/
    SUBN_Cantabria__ES_("Cantabria (ES)"),

    /*** País Vasco (ES) ***/
    SUBN_País_Vasco__ES_("País Vasco (ES)"),

    /*** Comunidad Foral de Navarra (ES) ***/
    SUBN_Comunidad_Foral_de_Navarr("Comunidad Foral de Navarra (ES)"),

    /*** La Rioja (ES) ***/
    SUBN_La_Rioja__ES_("La Rioja (ES)"),

    /*** Aragón (ES) ***/
    SUBN_Aragón__ES_("Aragón (ES)"),

    /*** Comunidad de Madrid (ES) ***/
    SUBN_Comunidad_de_Madrid__ES_("Comunidad de Madrid (ES)"),

    /*** Castilla y León (ES) ***/
    SUBN_Castilla_y_León__ES_("Castilla y León (ES)"),

    /*** Castilla-La Mancha (ES) ***/
    SUBN_Castilla_La_Mancha__ES_("Castilla-La Mancha (ES)"),

    /*** Extremadura (ES) ***/
    SUBN_Extremadura__ES_("Extremadura (ES)"),

    /*** Cataluña (ES) ***/
    SUBN_Cataluña__ES_("Cataluña (ES)"),

    /*** Comunidad Valenciana (ES) ***/
    SUBN_Comunidad_Valenciana__ES_("Comunidad Valenciana (ES)"),

    /*** Illes Balears (ES) ***/
    SUBN_Illes_Balears__ES_("Illes Balears (ES)"),

    /*** Andalucía (ES) ***/
    SUBN_Andalucía__ES_("Andalucía (ES)"),

    /*** Región de Murcia (ES) ***/
    SUBN_Región_de_Murcia__ES_("Región de Murcia (ES)"),

    /*** Ciudad Autónoma de Ceuta (ES) ***/
    SUBN_Ciudad_Autónoma_de_Ceuta_("Ciudad Autónoma de Ceuta (ES)"),

    /*** Ciudad Autónoma de Melilla (ES) ***/
    SUBN_Ciudad_Autónoma_de_Melill("Ciudad Autónoma de Melilla (ES)"),

    /*** Canarias (ES) ***/
    SUBN_Canarias__ES_("Canarias (ES)"),

    /*** Extra-Regio NUTS 2 (ES) ***/
    SUBN_Extra_Regio_NUTS_2__ES_("Extra-Regio NUTS 2 (ES)"),

    /*** Île de France (FR) ***/
    SUBN_Île_de_France__FR_("Île de France (FR)"),

    /*** Champagne-Ardenne (FR) ***/
    SUBN_Champagne_Ardenne__FR_("Champagne-Ardenne (FR)"),

    /*** Picardie (FR) ***/
    SUBN_Picardie__FR_("Picardie (FR)"),

    /*** Haute-Normandie (FR) ***/
    SUBN_Haute_Normandie__FR_("Haute-Normandie (FR)"),

    /*** Centre (FR) ***/
    SUBN_Centre__FR_("Centre (FR)"),

    /*** Basse-Normandie (FR) ***/
    SUBN_Basse_Normandie__FR_("Basse-Normandie (FR)"),

    /*** Bourgogne (FR) ***/
    SUBN_Bourgogne__FR_("Bourgogne (FR)"),

    /*** Nord - Pas-de-Calais (FR) ***/
    SUBN_Nord___Pas_de_Calais__FR_("Nord - Pas-de-Calais (FR)"),

    /*** Lorraine (FR) ***/
    SUBN_Lorraine__FR_("Lorraine (FR)"),

    /*** Alsace (FR) ***/
    SUBN_Alsace__FR_("Alsace (FR)"),

    /*** Franche-Comté (FR) ***/
    SUBN_Franche_Comté__FR_("Franche-Comté (FR)"),

    /*** Pays de la Loire (FR) ***/
    SUBN_Pays_de_la_Loire__FR_("Pays de la Loire (FR)"),

    /*** Bretagne (FR) ***/
    SUBN_Bretagne__FR_("Bretagne (FR)"),

    /*** Poitou-Charentes (FR) ***/
    SUBN_Poitou_Charentes__FR_("Poitou-Charentes (FR)"),

    /*** Aquitaine (FR) ***/
    SUBN_Aquitaine__FR_("Aquitaine (FR)"),

    /*** Midi-Pyrénées (FR) ***/
    SUBN_Midi_Pyrénées__FR_("Midi-Pyrénées (FR)"),

    /*** Limousin (FR) ***/
    SUBN_Limousin__FR_("Limousin (FR)"),

    /*** Rhône-Alpes (FR) ***/
    SUBN_Rhône_Alpes__FR_("Rhône-Alpes (FR)"),

    /*** Auvergne (FR) ***/
    SUBN_Auvergne__FR_("Auvergne (FR)"),

    /*** Languedoc-Roussillon (FR) ***/
    SUBN_Languedoc_Roussillon__FR_("Languedoc-Roussillon (FR)"),

    /*** Provence-Alpes-Côte d'Azur (FR) ***/
    SUBN_Provence_Alpes_Côte_d_Azu("Provence-Alpes-Côte d'Azur (FR)"),

    /*** Corse (FR) ***/
    SUBN_Corse__FR_("Corse (FR)"),

    /*** Guadeloupe (FR) ***/
    SUBN_Guadeloupe__FR_("Guadeloupe (FR)"),

    /*** Martinique (FR) ***/
    SUBN_Martinique__FR_("Martinique (FR)"),

    /*** Guyane (FR) ***/
    SUBN_Guyane__FR_("Guyane (FR)"),

    /*** Réunion (FR) ***/
    SUBN_Réunion__FR_("Réunion (FR)"),

    /*** Extra-Regio NUTS 2 (FR) ***/
    SUBN_Extra_Regio_NUTS_2__FR_("Extra-Regio NUTS 2 (FR)"),

    /*** Piemonte (IT) ***/
    SUBN_Piemonte__IT_("Piemonte (IT)"),

    /*** Valle d'Aosta/Vallée d'Aoste (IT) ***/
    SUBN_Valle_d_Aosta_Vallée_d_Ao("Valle d'Aosta/Vallée d'Aoste (IT)"),

    /*** Liguria (IT) ***/
    SUBN_Liguria__IT_("Liguria (IT)"),

    /*** Lombardia (IT) ***/
    SUBN_Lombardia__IT_("Lombardia (IT)"),

    /*** Abruzzo (IT) ***/
    SUBN_Abruzzo__IT_("Abruzzo (IT)"),

    /*** Molise (IT) ***/
    SUBN_Molise__IT_("Molise (IT)"),

    /*** Campania (IT) ***/
    SUBN_Campania__IT_("Campania (IT)"),

    /*** Puglia (IT) ***/
    SUBN_Puglia__IT_("Puglia (IT)"),

    /*** Basilicata (IT) ***/
    SUBN_Basilicata__IT_("Basilicata (IT)"),

    /*** Calabria (IT) ***/
    SUBN_Calabria__IT_("Calabria (IT)"),

    /*** Sicilia (IT) ***/
    SUBN_Sicilia__IT_("Sicilia (IT)"),

    /*** Sardegna (IT) ***/
    SUBN_Sardegna__IT_("Sardegna (IT)"),

    /*** Provincia Autonoma di Bolzano/Bozen (IT) ***/
    SUBN_Provincia_Autonoma_di_Bol("Provincia Autonoma di Bolzano/Bozen (IT)"),

    /*** Provincia Autonoma di Trento (IT) ***/
    SUBN_Provincia_Autonoma_di_Tre("Provincia Autonoma di Trento (IT)"),

    /*** Veneto (IT) ***/
    SUBN_Veneto__IT_("Veneto (IT)"),

    /*** Friuli-Venezia Giulia (IT) ***/
    SUBN_Friuli_Venezia_Giulia__IT("Friuli-Venezia Giulia (IT)"),

    /*** Emilia-Romagna (IT) ***/
    SUBN_Emilia_Romagna__IT_("Emilia-Romagna (IT)"),

    /*** Toscana (IT) ***/
    SUBN_Toscana__IT_("Toscana (IT)"),

    /*** Umbria (IT) ***/
    SUBN_Umbria__IT_("Umbria (IT)"),

    /*** Marche (IT) ***/
    SUBN_Marche__IT_("Marche (IT)"),

    /*** Lazio (IT) ***/
    SUBN_Lazio__IT_("Lazio (IT)"),

    /*** Extra-Regio NUTS 2 (IT) ***/
    SUBN_Extra_Regio_NUTS_2__IT_("Extra-Regio NUTS 2 (IT)"),

    /*** Κύπρος (Kýpros) (CY) ***/
    SUBN_Κύπρος__Kýpros___CY_("Κύπρος (Kýpros) (CY)"),

    /*** Extra-Regio NUTS 2 (CY) ***/
    SUBN_Extra_Regio_NUTS_2__CY_("Extra-Regio NUTS 2 (CY)"),

    /*** Latvija (LV) ***/
    SUBN_Latvija__LV_("Latvija (LV)"),

    /*** Extra-Regio NUTS 2 (LV) ***/
    SUBN_Extra_Regio_NUTS_2__LV_("Extra-Regio NUTS 2 (LV)"),

    /*** Lietuva (LT) ***/
    SUBN_Lietuva__LT_("Lietuva (LT)"),

    /*** Extra-Regio NUTS 2 (LT) ***/
    SUBN_Extra_Regio_NUTS_2__LT_("Extra-Regio NUTS 2 (LT)"),

    /*** Luxembourg (LU) ***/
    SUBN_Luxembourg__LU_("Luxembourg (LU)"),

    /*** Extra-Regio NUTS 2 (LU) ***/
    SUBN_Extra_Regio_NUTS_2__LU_("Extra-Regio NUTS 2 (LU)"),

    /*** Közép-Magyarország (HU) ***/
    SUBN_Közép_Magyarország__HU_("Közép-Magyarország (HU)"),

    /*** Közép-Dunántúl (HU) ***/
    SUBN_Közép_Dunántúl__HU_("Közép-Dunántúl (HU)"),

    /*** Nyugat-Dunántúl (HU) ***/
    SUBN_Nyugat_Dunántúl__HU_("Nyugat-Dunántúl (HU)"),

    /*** Dél-Dunántúl (HU) ***/
    SUBN_Dél_Dunántúl__HU_("Dél-Dunántúl (HU)"),

    /*** Észak-Magyarország (HU) ***/
    SUBN_Észak_Magyarország__HU_("Észak-Magyarország (HU)"),

    /*** Észak-Alföld (HU) ***/
    SUBN_Észak_Alföld__HU_("Észak-Alföld (HU)"),

    /*** Dél-Alföld (HU) ***/
    SUBN_Dél_Alföld__HU_("Dél-Alföld (HU)"),

    /*** Extra-Regio NUTS 2 (HU) ***/
    SUBN_Extra_Regio_NUTS_2__HU_("Extra-Regio NUTS 2 (HU)"),

    /*** Malta (MT) ***/
    SUBN_Malta__MT_("Malta (MT)"),

    /*** Extra-Regio NUTS 2 (MT) ***/
    SUBN_Extra_Regio_NUTS_2__MT_("Extra-Regio NUTS 2 (MT)"),

    /*** Groningen (NL) ***/
    SUBN_Groningen__NL_("Groningen (NL)"),

    /*** Friesland (NL) (NL) ***/
    SUBN_Friesland__NL___NL_("Friesland (NL) (NL)"),

    /*** Drenthe (NL) ***/
    SUBN_Drenthe__NL_("Drenthe (NL)"),

    /*** Overijssel (NL) ***/
    SUBN_Overijssel__NL_("Overijssel (NL)"),

    /*** Gelderland (NL) ***/
    SUBN_Gelderland__NL_("Gelderland (NL)"),

    /*** Flevoland (NL) ***/
    SUBN_Flevoland__NL_("Flevoland (NL)"),

    /*** Utrecht (NL) ***/
    SUBN_Utrecht__NL_("Utrecht (NL)"),

    /*** Noord-Holland (NL) ***/
    SUBN_Noord_Holland__NL_("Noord-Holland (NL)"),

    /*** Zuid-Holland (NL) ***/
    SUBN_Zuid_Holland__NL_("Zuid-Holland (NL)"),

    /*** Zeeland (NL) ***/
    SUBN_Zeeland__NL_("Zeeland (NL)"),

    /*** Noord-Brabant (NL) ***/
    SUBN_Noord_Brabant__NL_("Noord-Brabant (NL)"),

    /*** Limburg (NL) (NL) ***/
    SUBN_Limburg__NL___NL_("Limburg (NL) (NL)"),

    /*** Extra-Regio NUTS 2 (NL) ***/
    SUBN_Extra_Regio_NUTS_2__NL_("Extra-Regio NUTS 2 (NL)"),

    /*** Burgenland (AT) (AT) ***/
    SUBN_Burgenland__AT___AT_("Burgenland (AT) (AT)"),

    /*** Niederösterreich (AT) ***/
    SUBN_Niederösterreich__AT_("Niederösterreich (AT)"),

    /*** Wien (AT) ***/
    SUBN_Wien__AT_("Wien (AT)"),

    /*** Kärnten (AT) ***/
    SUBN_Kärnten__AT_("Kärnten (AT)"),

    /*** Steiermark (AT) ***/
    SUBN_Steiermark__AT_("Steiermark (AT)"),

    /*** Oberösterreich (AT) ***/
    SUBN_Oberösterreich__AT_("Oberösterreich (AT)"),

    /*** Salzburg (AT) ***/
    SUBN_Salzburg__AT_("Salzburg (AT)"),

    /*** Tirol (AT) ***/
    SUBN_Tirol__AT_("Tirol (AT)"),

    /*** Vorarlberg (AT) ***/
    SUBN_Vorarlberg__AT_("Vorarlberg (AT)"),

    /*** Extra-Regio NUTS 2 (AT) ***/
    SUBN_Extra_Regio_NUTS_2__AT_("Extra-Regio NUTS 2 (AT)"),

    /*** Łódzkie (PL) ***/
    SUBN_Łódzkie__PL_("Łódzkie (PL)"),

    /*** Mazowieckie (PL) ***/
    SUBN_Mazowieckie__PL_("Mazowieckie (PL)"),

    /*** Małopolskie (PL) ***/
    SUBN_Małopolskie__PL_("Małopolskie (PL)"),

    /*** Śląskie (PL) ***/
    SUBN_Śląskie__PL_("Śląskie (PL)"),

    /*** Lubelskie (PL) ***/
    SUBN_Lubelskie__PL_("Lubelskie (PL)"),

    /*** Podkarpackie (PL) ***/
    SUBN_Podkarpackie__PL_("Podkarpackie (PL)"),

    /*** Świętokrzyskie (PL) ***/
    SUBN_Świętokrzyskie__PL_("Świętokrzyskie (PL)"),

    /*** Podlaskie (PL) ***/
    SUBN_Podlaskie__PL_("Podlaskie (PL)"),

    /*** Wielkopolskie (PL) ***/
    SUBN_Wielkopolskie__PL_("Wielkopolskie (PL)"),

    /*** Zachodniopomorskie (PL) ***/
    SUBN_Zachodniopomorskie__PL_("Zachodniopomorskie (PL)"),

    /*** Lubuskie (PL) ***/
    SUBN_Lubuskie__PL_("Lubuskie (PL)"),

    /*** Dolnośląskie (PL) ***/
    SUBN_Dolnośląskie__PL_("Dolnośląskie (PL)"),

    /*** Opolskie (PL) ***/
    SUBN_Opolskie__PL_("Opolskie (PL)"),

    /*** Kujawsko-Pomorskie (PL) ***/
    SUBN_Kujawsko_Pomorskie__PL_("Kujawsko-Pomorskie (PL)"),

    /*** Warmińsko-Mazurskie (PL) ***/
    SUBN_Warmińsko_Mazurskie__PL_("Warmińsko-Mazurskie (PL)"),

    /*** Pomorskie (PL) ***/
    SUBN_Pomorskie__PL_("Pomorskie (PL)"),

    /*** Extra-Regio NUTS 2 (PL) ***/
    SUBN_Extra_Regio_NUTS_2__PL_("Extra-Regio NUTS 2 (PL)"),

    /*** Norte (PT) ***/
    SUBN_Norte__PT_("Norte (PT)"),

    /*** Algarve (PT) ***/
    SUBN_Algarve__PT_("Algarve (PT)"),

    /*** Centro (PT) (PT) ***/
    SUBN_Centro__PT___PT_("Centro (PT) (PT)"),

    /*** Lisboa (PT) ***/
    SUBN_Lisboa__PT_("Lisboa (PT)"),

    /*** Alentejo (PT) ***/
    SUBN_Alentejo__PT_("Alentejo (PT)"),

    /*** Região Autónoma dos Açores (PT) ***/
    SUBN_Região_Autónoma_dos_Açore("Região Autónoma dos Açores (PT)"),

    /*** Região Autónoma da Madeira (PT) ***/
    SUBN_Região_Autónoma_da_Madeir("Região Autónoma da Madeira (PT)"),

    /*** Extra-Regio NUTS 2 (PT) ***/
    SUBN_Extra_Regio_NUTS_2__PT_("Extra-Regio NUTS 2 (PT)"),

    /*** Nord-Vest (RO) ***/
    SUBN_Nord_Vest__RO_("Nord-Vest (RO)"),

    /*** Centru (RO) ***/
    SUBN_Centru__RO_("Centru (RO)"),

    /*** Nord-Est (RO) ***/
    SUBN_Nord_Est__RO_("Nord-Est (RO)"),

    /*** Sud-Est (RO) ***/
    SUBN_Sud_Est__RO_("Sud-Est (RO)"),

    /*** Sud - Muntenia (RO) ***/
    SUBN_Sud___Muntenia__RO_("Sud - Muntenia (RO)"),

    /*** Bucureşti - Ilfov (RO) ***/
    SUBN_Bucureşti___Ilfov__RO_("Bucureşti - Ilfov (RO)"),

    /*** Sud-Vest Oltenia (RO) ***/
    SUBN_Sud_Vest_Oltenia__RO_("Sud-Vest Oltenia (RO)"),

    /*** Vest (RO) ***/
    SUBN_Vest__RO_("Vest (RO)"),

    /*** Extra-Regio NUTS 2 (RO) ***/
    SUBN_Extra_Regio_NUTS_2__RO_("Extra-Regio NUTS 2 (RO)"),

    /*** Vzhodna Slovenija (SI) ***/
    SUBN_Vzhodna_Slovenija__SI_("Vzhodna Slovenija (SI)"),

    /*** Zahodna Slovenija (SI) ***/
    SUBN_Zahodna_Slovenija__SI_("Zahodna Slovenija (SI)"),

    /*** Extra-Regio NUTS 2 (SI) ***/
    SUBN_Extra_Regio_NUTS_2__SI_("Extra-Regio NUTS 2 (SI)"),

    /*** Bratislavský kraj (SK) ***/
    SUBN_Bratislavský_kraj__SK_("Bratislavský kraj (SK)"),

    /*** Západné Slovensko (SK) ***/
    SUBN_Západné_Slovensko__SK_("Západné Slovensko (SK)"),

    /*** Stredné Slovensko (SK) ***/
    SUBN_Stredné_Slovensko__SK_("Stredné Slovensko (SK)"),

    /*** Východné Slovensko (SK) ***/
    SUBN_Východné_Slovensko__SK_("Východné Slovensko (SK)"),

    /*** Extra-Regio NUTS 2 (SK) ***/
    SUBN_Extra_Regio_NUTS_2__SK_("Extra-Regio NUTS 2 (SK)"),

    /*** Länsi-Suomi (FI) ***/
    SUBN_Länsi_Suomi__FI_("Länsi-Suomi (FI)"),

    /*** Helsinki-Uusimaa (FI) ***/
    SUBN_Helsinki_Uusimaa__FI_("Helsinki-Uusimaa (FI)"),

    /*** Etelä-Suomi (FI) ***/
    SUBN_Etelä_Suomi__FI_("Etelä-Suomi (FI)"),

    /*** Pohjois- ja Itä-Suomi (FI) ***/
    SUBN_Pohjois__ja_Itä_Suomi__FI("Pohjois- ja Itä-Suomi (FI)"),

    /*** Åland (FI) ***/
    SUBN_Åland__FI_("Åland (FI)"),

    /*** Extra-Regio NUTS 2 (FI) ***/
    SUBN_Extra_Regio_NUTS_2__FI_("Extra-Regio NUTS 2 (FI)"),

    /*** Stockholm (SE) ***/
    SUBN_Stockholm__SE_("Stockholm (SE)"),

    /*** Östra Mellansverige (SE) ***/
    SUBN_Östra_Mellansverige__SE_("Östra Mellansverige (SE)"),

    /*** Småland med öarna (SE) ***/
    SUBN_Småland_med_öarna__SE_("Småland med öarna (SE)"),

    /*** Sydsverige (SE) ***/
    SUBN_Sydsverige__SE_("Sydsverige (SE)"),

    /*** Västsverige (SE) ***/
    SUBN_Västsverige__SE_("Västsverige (SE)"),

    /*** Norra Mellansverige (SE) ***/
    SUBN_Norra_Mellansverige__SE_("Norra Mellansverige (SE)"),

    /*** Mellersta Norrland (SE) ***/
    SUBN_Mellersta_Norrland__SE_("Mellersta Norrland (SE)"),

    /*** Övre Norrland (SE) ***/
    SUBN_Övre_Norrland__SE_("Övre Norrland (SE)"),

    /*** Extra-Regio NUTS 2 (SE) ***/
    SUBN_Extra_Regio_NUTS_2__SE_("Extra-Regio NUTS 2 (SE)"),

    /*** Tees Valley and Durham (UK) ***/
    SUBN_Tees_Valley_and_Durham__U("Tees Valley and Durham (UK)"),

    /*** Northumberland and Tyne and Wear (UK) ***/
    SUBN_Northumberland_and_Tyne_a("Northumberland and Tyne and Wear (UK)"),

    /*** Cumbria (UK) ***/
    SUBN_Cumbria__UK_("Cumbria (UK)"),

    /*** Greater Manchester (UK) ***/
    SUBN_Greater_Manchester__UK_("Greater Manchester (UK)"),

    /*** Lancashire (UK) ***/
    SUBN_Lancashire__UK_("Lancashire (UK)"),

    /*** Cheshire (UK) ***/
    SUBN_Cheshire__UK_("Cheshire (UK)"),

    /*** Merseyside (UK) ***/
    SUBN_Merseyside__UK_("Merseyside (UK)"),

    /*** East Yorkshire and Northern Lincolnshire (UK) ***/
    SUBN_East_Yorkshire_and_Northe("East Yorkshire and Northern Lincolnshire (UK)"),

    /*** North Yorkshire (UK) ***/
    SUBN_North_Yorkshire__UK_("North Yorkshire (UK)"),

    /*** South Yorkshire (UK) ***/
    SUBN_South_Yorkshire__UK_("South Yorkshire (UK)"),

    /*** West Yorkshire (UK) ***/
    SUBN_West_Yorkshire__UK_("West Yorkshire (UK)"),

    /*** Derbyshire and Nottinghamshire (UK) ***/
    SUBN_Derbyshire_and_Nottingham("Derbyshire and Nottinghamshire (UK)"),

    /*** Leicestershire, Rutland and Northamptonshire (UK) ***/
    SUBN_Leicestershire__Rutland_a("Leicestershire, Rutland and Northamptonshire (UK)"),

    /*** Lincolnshire (UK) ***/
    SUBN_Lincolnshire__UK_("Lincolnshire (UK)"),

    /*** Herefordshire, Worcestershire and Warwickshire (UK) ***/
    SUBN_Herefordshire__Worcesters("Herefordshire, Worcestershire and Warwickshire (UK)"),

    /*** Shropshire and Staffordshire (UK) ***/
    SUBN_Shropshire_and_Staffordsh("Shropshire and Staffordshire (UK)"),

    /*** West Midlands (UK) ***/
    SUBN_West_Midlands__UK_("West Midlands (UK)"),

    /*** East Anglia (UK) ***/
    SUBN_East_Anglia__UK_("East Anglia (UK)"),

    /*** Bedfordshire and Hertfordshire (UK) ***/
    SUBN_Bedfordshire_and_Hertford("Bedfordshire and Hertfordshire (UK)"),

    /*** Essex (UK) ***/
    SUBN_Essex__UK_("Essex (UK)"),

    /*** Inner London (UK) ***/
    SUBN_Inner_London__UK_("Inner London (UK)"),

    /*** Outer London (UK) ***/
    SUBN_Outer_London__UK_("Outer London (UK)"),

    /*** Berkshire, Buckinghamshire and Oxfordshire (UK) ***/
    SUBN_Berkshire__Buckinghamshir("Berkshire, Buckinghamshire and Oxfordshire (UK)"),

    /*** Surrey, East and West Sussex (UK) ***/
    SUBN_Surrey__East_and_West_Sus("Surrey, East and West Sussex (UK)"),

    /*** Hampshire and Isle of Wight (UK) ***/
    SUBN_Hampshire_and_Isle_of_Wig("Hampshire and Isle of Wight (UK)"),

    /*** Kent (UK) ***/
    SUBN_Kent__UK_("Kent (UK)"),

    /*** Gloucestershire, Wiltshire and Bristol/Bath area (UK) ***/
    SUBN_Gloucestershire__Wiltshir("Gloucestershire, Wiltshire and Bristol/Bath area (UK)"),

    /*** Dorset and Somerset (UK) ***/
    SUBN_Dorset_and_Somerset__UK_("Dorset and Somerset (UK)"),

    /*** Cornwall and Isles of Scilly (UK) ***/
    SUBN_Cornwall_and_Isles_of_Sci("Cornwall and Isles of Scilly (UK)"),

    /*** Devon (UK) ***/
    SUBN_Devon__UK_("Devon (UK)"),

    /*** West Wales and The Valleys (UK) ***/
    SUBN_West_Wales_and_The_Valley("West Wales and The Valleys (UK)"),

    /*** East Wales (UK) ***/
    SUBN_East_Wales__UK_("East Wales (UK)"),

    /*** Eastern Scotland (UK) ***/
    SUBN_Eastern_Scotland__UK_("Eastern Scotland (UK)"),

    /*** South Western Scotland (UK) ***/
    SUBN_South_Western_Scotland__U("South Western Scotland (UK)"),

    /*** North Eastern Scotland (UK) ***/
    SUBN_North_Eastern_Scotland__U("North Eastern Scotland (UK)"),

    /*** Highlands and Islands (UK) ***/
    SUBN_Highlands_and_Islands__UK("Highlands and Islands (UK)"),

    /*** Northern Ireland (UK) ***/
    SUBN_Northern_Ireland__UK_("Northern Ireland (UK)"),

    /*** Extra-Regio NUTS 2 (UK) ***/
    SUBN_Extra_Regio_NUTS_2__UK_("Extra-Regio NUTS 2 (UK)"),



    /**
     *  Northern Periphery
     */
    TRANS_MACRO_NORTHPERI,

    /**
     *  Baltic Sea
     */
    TRANS_MACRO_BACLITC,

    /**
     *  North West Europe
     */
    TRANS_MACRO_NW_EUROPE,

    /**
     *  North Sea
     */
    TRANS_MACRO_N_SEA,

    /**
     *  Atlantic Area
     */
    TRANS_MACRO_ATL_AREA,

    /**
     *  Alpine Space
     */
    TRANS_MACRO_ALP_SPACE,

    /**
     *  Central Europe
     */
    TRANS_MACRO_CEN_EUR,

    /**
     *  South West Europe
     */
    TRANS_MACRO_SW_EUR,

    /**
     *  Mediterranean
     */
    TRANS_MACRO_MED,

    /**
     *  South East Europe
     */
    TRANS_MACRO_SE_EUR,

    /**
     *  Caribbean Area
     */
    TRANS_MACRO_CAR_AREA,

    /**
     *  Macronesia
     */
    TRANS_MACRO_MACRONESIA,

    /**
     * Indian Ocean Area
     */
    TRANS_MACRO_IND_OCEAN_AREA,

    /**
     * Alpine
     */
    TRANS_BIO_ALPINE,

    /**
     * Atlantic
     */
    TRANS_BIO_ATLANTIC,

    /**
     * Arctic
     */
    TRANS_BIO_ARCTIC,

    /**
     * Continental
     */
    TRANS_BIO_CONTINENTAL,

    /**
     * Mediterranean
     */
    TRANS_BIO_MEDIT,

    /**
     * Panonian
     */
    TRANS_BIO_PANONIAN;

    private String description = "";

    AceItemGeoChars()
    {

    }

    AceItemGeoChars(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }

  }

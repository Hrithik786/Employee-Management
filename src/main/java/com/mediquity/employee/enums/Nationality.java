package com.mediquity.employee.enums;

public enum Nationality {
    INDIAN("Indian", "IN"),
    AMERICAN("American", "US"),
    BRITISH("British", "GB"),
    CANADIAN("Canadian", "CA"),
    AUSTRALIAN("Australian", "AU"),
    GERMAN("German", "DE"),
    FRENCH("French", "FR"),
    JAPANESE("Japanese", "JP"),
    CHINESE("Chinese", "CN"),
    BRAZILIAN("Brazilian", "BR"),
    MEXICAN("Mexican", "MX"),
    ITALIAN("Italian", "IT"),
    SPANISH("Spanish", "ES"),
    RUSSIAN("Russian", "RU"),
    SOUTH_AFRICAN("South African", "ZA"),
    SINGAPOREAN("Singaporean", "SG"),
    MALAYSIAN("Malaysian", "MY"),
    THAI("Thai", "TH"),
    INDONESIAN("Indonesian", "ID"),
    FILIPINO("Filipino", "PH"),
    KOREAN("Korean", "KR"),
    VIETNAMESE("Vietnamese", "VN"),
    BANGLADESHI("Bangladeshi", "BD"),
    PAKISTANI("Pakistani", "PK"),
    SRI_LANKAN("Sri Lankan", "LK"),
    NEPALESE("Nepalese", "NP"),
    DUTCH("Dutch", "NL"),
    SWISS("Swiss", "CH"),
    SWEDISH("Swedish", "SE"),
    NORWEGIAN("Norwegian", "NO"),
    DANISH("Danish", "DK"),
    FINNISH("Finnish", "FI"),
    BELGIAN("Belgian", "BE"),
    AUSTRIAN("Austrian", "AT"),
    PORTUGUESE("Portuguese", "PT"),
    GREEK("Greek", "GR"),
    TURKISH("Turkish", "TR"),
    EGYPTIAN("Egyptian", "EG"),
    NIGERIAN("Nigerian", "NG"),
    KENYAN("Kenyan", "KE"),
    ETHIOPIAN("Ethiopian", "ET"),
    MOROCCAN("Moroccan", "MA"),
    ARGENTINIAN("Argentinian", "AR"),
    CHILEAN("Chilean", "CL"),
    COLOMBIAN("Colombian", "CO"),
    PERUVIAN("Peruvian", "PE"),
    VENEZUELAN("Venezuelan", "VE"),
    SAUDI_ARABIAN("Saudi Arabian", "SA"),
    UAE_NATIONAL("UAE National", "AE"),
    QATARI("Qatari", "QA"),
    KUWAITI("Kuwaiti", "KW"),
    ISRAELI("Israeli", "IL"),
    IRANIAN("Iranian", "IR"),
    IRAQI("Iraqi", "IQ"),
    AFGHAN("Afghan", "AF"),
    OTHER("Other", "XX");
    
    private final String displayName;
    private final String countryCode;
    
    Nationality(String displayName, String countryCode) {
        this.displayName = displayName;
        this.countryCode = countryCode;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getCountryCode() {
        return countryCode;
    }
    
    // Utility method to find by country code
    public static Nationality findByCountryCode(String code) {
        for (Nationality nationality : values()) {
            if (nationality.countryCode.equalsIgnoreCase(code)) {
                return nationality;
            }
        }
        return OTHER;
    }
}
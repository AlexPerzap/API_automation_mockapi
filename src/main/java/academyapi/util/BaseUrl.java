package academyapi.util;

public enum BaseUrl {

    USERS_URL("https://602b2e9def26b40017f1405d.mockapi.io/mock/api/bank/users/");
    private final String url;

    BaseUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}

function() {
    var env = karate.env;
    if (env == 'dev') {
        var apiURL = 'http://127.0.0.1:9090/'
    } else if (env == 'stg') {
        var apiURL = 'http://192.168.33.10:9090'
    }
    var config = {
        apiURL: apiURL
    };

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
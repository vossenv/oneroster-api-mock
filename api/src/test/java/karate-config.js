function() {
    var env = karate.env;
    if (env == 'dev') {
        var apiURL = 'the_dev_url'
    } else if (env == 'stg') {
        var apiURL = 'the_stage_url'
    }
    var config = {
        apiURL: apiURL
    };

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
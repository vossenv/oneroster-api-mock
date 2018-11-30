
scp build/libs/oneroster-api-1.0.jar deployment@thenewcarag.com:/usr/springboot/oneroster
scp orcert.pfx deployment@thenewcarag.com:/usr/springboot/oneroster
ssh deployment@thenewcarag.com sudo service oneroster-api restart
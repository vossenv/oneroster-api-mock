function() {
    var env = karate.env;
    if (env == 'dev') {
        var apiURL = 'https://127.0.0.1:9090/'
    } else if (env == 'stg') {
        var apiURL = 'https://192.168.33.10:9090/'
    } else if (env == 'local') {
        var apiURL = 'https://localhost:9090/'
    }

    karate.configure('ssl', true);

    var userObject =
        {   userId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            enabledUser: '#string',
            userIds: '#string',
            identifier: '#string',
            schoolId: '#string',
            givenName: '#string',
            familyName: '#string',
            middleName: '#string',
            email: '#string',
            username: '#string',
            phone: '#string',
            role: '#string',
            grades: '#string',
            type: '#string',
            password: '#string'
        };

    var studentObject =
        {   userId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            enabledUser: '#string',
            userIds: '#string',
            identifier: '#string',
            schoolId: '#string',
            givenName: '#string',
            familyName: '#string',
            middleName: '#string',
            email: '#string',
            username: '#string',
            phone: '#string',
            role: 'student',
            grades: '#string',
            type: '#string',
            password: '#string'
        };

    var teacherObject =
        {   userId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            enabledUser: '#string',
            userIds: '#string',
            identifier: '#string',
            schoolId: '#string',
            givenName: '#string',
            familyName: '#string',
            middleName: '#string',
            email: '#string',
            username: '#string',
            phone: '#string',
            role: 'teacher',
            grades: '#string',
            type: '#string',
            password: '#string'
        };

    var classObject =
        {   classId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            term: '#string',
            classCode: '#string',
            classType: '#string',
            location: '#string',
            courseId: '#string',
            schoolId: '#string',
            periods: '#string'
        };

    var schoolObject =
        {   schoolId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            name: '#string',
            identifier: '#string',
            type: '#string'
        };

    var courseObject =
        {   courseId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            grade: '#string',
            title: '#string',
            schoolYear: '#string',
            courseCode: '#string',
            subjects: '#string',
            schoolId: '#string'
        };

    var enrollmentObject =
        {   enrollmentId: '#string',
            sourcedId: '#string',
            status: '#string',
            dateLastModified: '#string',
            metadata: '#string',
            userId: '#string',
            classId: '#string',
            primary: '#string',
            beginDate: '#string',
            endDate: '#string'
        };

    var errorObject =
        {   timestamp: '#string',
            status: '#string',
            message: '#string',
            errorMessageList: '#array'
        };

    var invalidIdString = 'potato';

    var config = {
        URL: apiURL,
        USER: userObject,
        STUDENT: studentObject,
        TEACHER: teacherObject,
        CLASS: classObject,
        SCHOOL: schoolObject,
        COURSE: courseObject,
        ENROLLMENT: enrollmentObject,
        ERROR: errorObject,
        INVALID_ID: invalidIdString
    };




    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 15000);
    return config;
}
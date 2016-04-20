modules = {
    blog {
        dependsOn 'bootstrap'
        dependsOn 'jquery-ui'

        resource url:'css/blog.css'
        resource url:'js/application.js'
    }

    'jquery-ui' {
        resource url:'css/jquery-ui.min.css'
        resource url:'css/jquery-ui.theme.min.css'
        resource url:'js/jquery-ui.min.js'
    }
}
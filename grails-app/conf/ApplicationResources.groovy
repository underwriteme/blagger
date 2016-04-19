modules = {
    blog {
        dependsOn 'bootstrap'
        dependsOn 'typeahead'

        resource url:'css/blog.css'
        resource url:'js/application.js'
    }

    typeahead {
        resource url:'js/typeahead.js'
    }
}
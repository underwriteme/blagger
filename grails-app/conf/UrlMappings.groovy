class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'blog', action: 'listPaged')
        "500"(view: '/error')
    }
}

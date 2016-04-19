package blagger

import grails.converters.JSON

class TagController {

    def list() {
        def tagResponse = (0..4).collect {
            "${params.stem}${it}"
        }

        render tagResponse as JSON
    }
}

package blagger

import grails.converters.JSON
import grails.validation.ValidationException

class BlogController {

    static defaultAction = "list"

    def listPaged() {
        Integer offset = params.int("offset") ?: 0
        Integer max = Math.min(params.int("max") ?: 5, 100)

        if (params.data == 'all') {
            params.data = '%';
        }

//        def c = Post.createCriteria()
//        def sortedPosts = c {
//            maxResults(max)
//            firstResult(offset) //todo firstresult seems to be broken in criteriabuilder
//            order 'id', 'desc'
//        }

        def sortedPosts = Post.createCriteria().list(max: max, offset: offset) {
            order 'id', 'desc'
            if (params.tag) {
                tag { ilike("name", params.tag) }
            }
        }

        render(view: "list", model: [posts: sortedPosts, postCount: sortedPosts?.totalCount ?: 0, max: max, offset: offset])
    }

    def list() {
        List sortedPosts = Post.list().sort { lhs, rhs -> rhs.id <=> lhs.id }

        [posts: sortedPosts, postCount: sortedPosts.size()]
    }

    def create() {
        [post: new Post(params)]
    }

    def createPost() {

        def aPost = new Post(params)

        if (!aPost.save(flush: true)) {
            render(view: "create", model: [post: aPost])
            return
        }

        redirect(action: 'list')
    }

    def createTag() {
        log.debug(params.txtTag)
        try {
            def tagInstance = new Tag(name: params.txtTag)
            tagInstance.save(failOnError: true)
            log.debug("$params.txtTag saved")
            render tagInstance as JSON
        } catch (ValidationException ex) {
            response.status = 400
            render 'Invalid or duplicate tag name'
        } catch (Exception ex) {
            response.status = 400
            render 'Error saving tag name'
        }
    }

    def addTag() {
        log.debug(params.id)
        def postInstance = Post.get(params.id)
        postInstance.tag = Tag.findByNameIlike(params.tag)
        postInstance.save()
        def json = [
                "tag": postInstance.tag,
                "id": postInstance.id,
        ] as JSON
        render json
    }

    def findTag() {
        List tags = Tag.findByNameIlike("%" + params.term + "%").collect() {
            return it.name
        }
        def results = ["options": tags]
        log.debug(params.term)
        log.debug(results)
        render results as JSON
    }

}

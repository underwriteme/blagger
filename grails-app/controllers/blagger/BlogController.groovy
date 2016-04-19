package blagger

class BlogController {

    static defaultAction = "list"

    def list() {
        [posts: Post.list(sort: "id", order: "desc")]
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
}

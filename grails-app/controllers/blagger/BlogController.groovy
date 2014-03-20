package blagger

class BlogController {

    static defaultAction = "list"

    def list() {
        [posts: Post.list(max:5, offset:params.offset?:0).sort { lhs, rhs -> rhs.id <=> lhs.id }, postCount: Post.count]
    }

    def create() {
        [categories: Post.createCriteria().list { projections { distinct("category") } }, post: new Post(params)]
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

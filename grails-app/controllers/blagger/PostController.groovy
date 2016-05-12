package blagger

class PostController {

    def index() {
        def posts = Post.list([sort: 'id', order: 'desc', max: 5] + params)
        [posts: posts, total: Post.count()]
    }

    def create() {
        [post: new Post(params)]
    }

    def savePost() {
        def newPost = new Post(params)

        if (!newPost.save(flush: true)) {
            render(view: 'create', model: [post: newPost])
            return
        }

        redirect(action: 'index')
    }
}

package blagger

class PostController {

    def index() {
        [posts: Post.list(sort: 'id', order: 'desc')]
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

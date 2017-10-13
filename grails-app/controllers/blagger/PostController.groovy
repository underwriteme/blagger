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
	 
	def indexByTag() {

        def posts = Post.findAllByTagIlike(wrapSearchParm(params.tag),[max: 10])
        render(view: 'index', model:  [posts: posts, total: Post.count()])
		return
    }
    
	def search() {
		/* println("action - search")	println(params?.tag) */
		def posts = Post.findAllByTagIlike(wrapSearchParm(params.tag),[max: 20])
		render(template:'searchResults', model:[searchresults: posts])
	 }
	 
	def String wrapSearchParm(value) {
	 		 '%'+value+'%'
	 }
	  
    
}

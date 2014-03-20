package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated
	String category

    static constraints = {
		title    blank: false, minSize: 3
		email    blank: false, email: true
		content  blank: false
		category blank: false
    }

    static mapping = {
        content type: 'text'
    }
	
	static def findPosts(category, offset) {
		if (!category) {
		    Post.list(max:5, offset:offset?:0)
		} else {
		    Post.createCriteria().list(max: 5,offset:offset?:0) {
                like("category", "%${category}%")
		    } 
    	}
    }
}

package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated

    static constraints = {
		title minSize: 3, blank: false
    }

    static mapping = {
        content type: 'text'
    }

}

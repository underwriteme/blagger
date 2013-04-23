package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
        content type: 'text'
    }

}

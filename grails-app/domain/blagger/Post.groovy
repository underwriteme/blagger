package blagger

class Post {

    String title
    String email
    String content
    Date dateCreated
    Date lastUpdated
    String tag

    static constraints = {
        title minSize: 3, blank: false
        email email: true, blank: false
        content blank: false
        tag maxSize: 20, blank: false
    }

    static mapping = {
        content type: 'text'
    }
}

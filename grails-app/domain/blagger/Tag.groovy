package blagger

/**
 * Created with IntelliJ IDEA.
 * User: barry
 * Date: 10/15/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
class Tag {

    String name

    static constraints = {
        name unique: true, blank: false
    }
}

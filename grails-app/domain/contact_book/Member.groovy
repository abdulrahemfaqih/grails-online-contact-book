package contact_book

class Member {
    Integer id
    String firtName
    String lastName
    String email
    String password
    String memberType = GlobalConfig.USER_TYPE.REGULER_MEMBER
    String identityHash
    Long identityHashLastUpdate
    Boolean isActive = true

    Date dateCreated
    Date lastUpdated

    static constraints = {
        email(email: true, nullable: false, unique: true, blank)
        password(blank: false)
        lastName(nullable: false)
        identityHash(nullable: true)
        identityHashLastUpdate(nullable: true)
    }

    def beforeInsert() {
        this.password = this.password.encodeAsMD5()
    }

    def beforeUpdate() {
        this.password = this.password.encodeAsMD5()
     }
}

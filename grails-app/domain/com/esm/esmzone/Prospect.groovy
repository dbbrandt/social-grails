package com.esm.esmzone

/**
 * Prospect is used to store prspective users that have not yet registered.
 * This may be recommended by friends or supplied by third parties
 * The source of the prospect can be either a valid source or a current user.
 */
class Prospect {
    Date dateCreated
    Date lastUpdated

    String email
    Source source
    User user

    static constraints = {
      email blank:false,nullable:false,email:true
      user nullable:true
      source nullable:false
    }

    String toString(){
        return email;
    }
}

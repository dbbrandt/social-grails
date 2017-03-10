package com.esm.dialog;

import com.esm.esmzone.User;

class Complaint {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [user:User]
	
	User user
	User author
	String message
	String content
	Long contentId
	ContentType type
	ComplaintType reason
	ComplaintStatus status = ComplaintStatus.PENDING
	
	static constraints = {
		user nullable:false
		author nullable:false
		content blank:false, nullable:false
		message blank:false, nullable:false
		status nullable:false
		contentId nullable:false
		type nullable:false
		reason nullable:false
	}
	
	String toString(){
		return "$message ($dateCreated)";
	}

	Object getContent() {
		def content
		switch (this.type) {
			case 'Post':
				content = Post.get(this.contentId)
				break
			case 'PostComment':
				content = PostComment.get(this.contentId)
				break
			case 'Answer':
				content = Answer.get(this.contentId)
				break
			case 'AnswerComment':
				content = AnswerComment.get(this.contentId)
				break
		}
		return content
	}
	
		
}

enum ComplaintStatus {
	PENDING, ACCEPTED, REJECTED
}
enum ContentType {
	Post, Answer, PostComment, AnswerComment
}
enum ComplaintType {
	OFFENSIVE, SPAM, OTHER
}
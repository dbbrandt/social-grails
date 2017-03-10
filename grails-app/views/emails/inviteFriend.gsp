<%@ page contentType="text/plain"%>

Congratulations!  Your friend, ${user}, has recruited you to become a member of ESMZone.


ESMZone is an exciting online community where student athletes compete against each other for points and prizes.
ESMZone is built around a simple formula: Ask. Answer. Win!

You will get 50 points for signing up to be a member and ${user.firstName} will get 50 points for recruiting you into ESMZone.

Click this link to get started, http://${request.getServerName()}<g:createLink controller="user" action="register"/>?coupon=${user?.email}&friendEmail=${prospect}

Once again Congratulations and Good Luck in the Competition!

The ESMZone Team.

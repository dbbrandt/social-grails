<%@ page contentType="text/plain"%>
Dear ${referenceInstance?.firstName} ${referenceInstance?.lastName},

${referenceInstance?.application?.mentor} has indicated you as a reference for their
application to be a mentor on ESMZone the student-athlete social site.

Please click on the following link to submit you reference: http://${request.getServerName()}<g:createLink controller="mentorApplication" action="referenceResponse" id="${referenceInstance?.application?.id}"/>&seq=${referenceInstance?.sequence}

Kind Regards,

The ESMZone Team
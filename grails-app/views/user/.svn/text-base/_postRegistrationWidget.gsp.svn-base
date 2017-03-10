<g:if test="${params.gender || (request.user && !request.user.gender)}">
  <div class="section">
      <h2 style="color:#9AB1C9;margin-top:10px;">Please complete your personal information to continue</h2>
      Current School:
      <gui:autoComplete
          id="schoolAutoInput"
          idField="id"
          style="autoInput1"
          controller="memberProfile"
          action="schoolAutocomplete"
          minQueryLength="3"
          value="${params.currentSchool}"
      /><br>
      Sports Played (select up to 3):<br>
      <g:select class="sports" name="playedSports1" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${params.playedSports1}"  noSelection="[null:' ']"/>
      <g:select class="sports" name="playedSports2" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${params.playedSports2}"  noSelection="[null:' ']"/>
      <g:select class="sports" name="playedSports3" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${params.playedSports3}"  noSelection="[null:' ']"/>
      <br>
      City:<br>
      <g:textField name="city" value="${params.city}"/><br>
      State:<br>
      <g:select class="state" name="state" from="${com.esm.esmzone.StateProvince.list()}" optionKey="abbreviation" value="${params.state}"  noSelection="[null:' ']"/><br>
      Gender:<br>
      <select type="text" name="gender">
          <option></option>
          <option ${(params.gender == "Male")?"selected":""}>Male</option>
          <option ${(params.gender == "Female")?"selected":""}>Female</option>
      </select>
  </div><!-- end div.registration -->
</g:if>

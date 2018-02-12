<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="generic-container">
    <div ng-controller="ConfigurationController">
        <form ng-submit="submit()">
            status/200 requests per minute: <input type="text" ng-model="config.model.rpmStatusOk"><br>
            <br>
            delay/n requests per minute: <input type="text" ng-model="config.model.rpmDelay"><br>
            <br>
            <input class="btn btn-success btn-lg" type="submit" value="Save" />
        </form>
    </div>
</div>
'use strict';

/* Directives */


angular.module('myApp.directives', []).
    directive('datetimepicker', function() {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                console.log(scope, element, attrs);
                element.datetimepicker({
                    format: 'dd/MM/yyyy hh:mm:ss'
                });
                element.on('changeDate', function(e) {
                    scope.datetime=e.date;
                    scope.$apply();
                });
            }
        };
    });



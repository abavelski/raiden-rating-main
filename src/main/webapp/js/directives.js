'use strict';

/* Directives */


angular.module('myApp.directives', []).
    directive('datetimepicker', function() {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                element.datetimepicker({
                    format: 'dd/MM/yyyy hh:mm:ss'
                });
                element.on('changeDate', function(e) {
                    scope[attrs.datevalue]=e.date;
                    scope.$apply();
                });
            }
        };
    });



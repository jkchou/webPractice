/**
 *
 * Active Charts using Highcharts demonstration
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright 2012, Script Tutorials
 * http://www.script-tutorials.com/
 */

// Change Chart type function
function ChangeChartType(chart, series, newType) {
    newType = newType.toLowerCase();
    for (var i = 0; i < series.length; i++) {
        var srs = series[0];
        try {
            srs.chart.addSeries({
                    type: newType,
                    stack: srs.stack,
                    yaxis: srs.yaxis,
                    name: srs.name,
                    color: srs.color,
                    data: srs.options.data
                },
                false);
            series[0].remove();
        } catch (e) {
        }
    }
}

// Two charts definition
var chart1;

// Once DOM (document) is finished loading
$(document).ready(function () {

    // First chart initialization
    chart1 = new Highcharts.Chart({
        chart: {
            renderTo: 'chart_6',
            type: 'spline',
            height: 350
        },
        title: {
            text: '',
            x: -20,
            style: {
                color: '#60AEE5'
            }
        }, subtitle: {
            text: '',
            x: -20
        },

        xAxis: {
            categories: [],
            labels: {
                enabled: false
            }
        },
        yAxis: [{

            title: {
                text: '使用量',
                style: {
                    color: '#666'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#60AEE5'
            }],
            labels: {
                enabled: false
            }

        }],

        series: [{
            name: '农资投入',
            data: null,
            yAxis: 0//与yAxis第几个对应从0开始

        }
        ]
    });


});
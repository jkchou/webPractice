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
            renderTo: 'chart_8',
            type: 'column',
            height: 350
        },
        title: {
            text: '',
            x: -20
        },

        xAxis: {
            categories: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月'],
            labels: {
                style: {
                    color: '#333'
                }
            }
        },
        yAxis: [{

            title: {
                text: '采收量（kg）',
                style: {
                    color: '#333'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            labels: {
                style: {
                    color: '#333'
                }
            }
        }, {
            title: {
                text: '订单量（kg）',
                style: {
                    color: '#333'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }], labels: {
                style: {
                    color: '#333'
                }
            }
            , opposite: true
        }],

        series: [{
            name: '订单量',
            data: [5, 10, 20, 22, 25, 28, 30, 20],
            yAxis: 0,//与yAxis第几个对应从0开始
            tooltip: {
                valueSuffix: 'kg'//预览窗口设对应单位
            }
        }, {
            name: '采收量',
            data: [15, 15, 18, 40, 30, 25, 50, 15],
            yAxis: 1,
            tooltip: {
                valueSuffix: 'kg'
            }
        }
        ]
    });


});
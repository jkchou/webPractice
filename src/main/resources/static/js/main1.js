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
            renderTo: 'chart_2',
            type: 'spline',
            height: 350,
            backgroundColor: 'rgba(0,0,0,0)'

        },
        title: {
            text: '',
            x: -20,
            style: {
                color: '#fff'
            }
        }, subtitle: {
            text: '',
            x: -20
        },

        xAxis: {
            categories: ['12日', '13日', '14日', '15日', '16日', '17日', '18日', '19日'],
            labels: {
                style: {
                    color: '#fff'
                }
            }
        },
        yAxis: [{

            title: {
                text: '温 度（°C）',
                style: {
                    color: '#fff'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            labels: {
                style: {
                    color: '#fff'
                }
            }
        }],

        series: [{
            name: '最高温度',
            data: [18, 20, 20, 22, 25, 28, 30, 20],
            yAxis: 0,//与yAxis第几个对应从0开始
            tooltip: {
                valueSuffix: '℃'//预览窗口设对应单位
            }
        }, {
            name: '最低温度',
            data: [8, 11, 13, 9, 11, 12, 14, 3],
            tooltip: {
                valueSuffix: '℃'
            }
        }
        ]
    });


});
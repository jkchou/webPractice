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
            renderTo: 'chart_dingdantongji',
            type: 'spline',
            height: 350
        },
        title: {
            text: '',
            x: -20,
            style: {
                color: '#000'
            }
        }, subtitle: {
            text: '',
            x: -20
        },

        xAxis: {
            categories: ['05-11', '05-12', '05-13', '05-14', '05-15', '05-16', '05-17', '05-18'],
            labels: {
                style: {
                    color: '#000'
                }
            }
        },
        yAxis: [{
            max: 8, // 定义Y轴 最大值
            min: 0, // 定义最小值
            tickInterval: 2, // 刻度值
            title: {
                text: '单',
                style: {
                    color: '#000'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            labels: {
                style: {
                    color: '#000'
                }
            }
        }],

        series: [{
            name: '农业集团科技有限公司',
            data: [0, 0, 0, 0, 0, 0, 0, 0]
        }
        ]
    });


});
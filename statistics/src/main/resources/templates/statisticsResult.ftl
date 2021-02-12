<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>chart</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
</head>
<body>
<h1>This is chart.</h1>
<canvas id="myChart" width="400" height="400"></canvas>
</body>
<script>

    const colors = ['red','yellow','blue','#c3e6cb','#dc3545','#6c757d'];

    var ctx = document.getElementById('myChart');
    var chartData = {
        labels: ["S", "M", "T", "W", "T", "F", "S"],
        datasets: [{ data: [589, 445, 483, 503, 689, 692, 634],
            backgroundColor: 'transparent',
            borderColor: colors[2],
            borderWidth: 3,
            pointBackgroundColor: colors[0]
        }, {
            data: [346, 503, 609, 503, 589, 483, 445],
            backgroundColor: colors[1],
            borderColor: colors[0],
            borderWidth: 3,
            pointBackgroundColor: colors[0]
        }]
    };
    var myChart = new Chart(ctx, {
        type: 'line',
        data: chartData,
        options: {
            legend: {
                display: false
            }
        }
    });

</script>
</html>
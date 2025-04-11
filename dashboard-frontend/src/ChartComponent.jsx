import {Bar} from "react-chartjs-2";
import {BarElement, CategoryScale, Chart as ChartJS, Legend, LinearScale, Title, Tooltip} from "chart.js";

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

function ChartComponent({ data }) {
    const chartData = {
        labels: data.map(point => point.date),
        datasets: [
            {
                label: 'Valeurs',
                data: data.map(point => point.value),
                backgroundColor: 'rgba(75, 192, 192, 0.6)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
            },
        ],
    };

    const options = {
        scales: {
            yAxes: {
                beginAtZero: true,
            },
        },
    };

    return <Bar data={chartData} options={options}/>;
}

export default ChartComponent;
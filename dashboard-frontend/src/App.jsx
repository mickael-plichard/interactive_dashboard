import ChartComponent from "./ChartComponent.jsx";
import userDashboardData from "./hooks/userDashboardData.js";


function App() {
    const {data, loading, error} = userDashboardData();

    if (loading) return <div>Loading...</div>;
    if (error) return <div>Something went wrong : {error.message}</div>;

    return (
        <div style={{padding: '20px'}}>
            <h1>Dashboard</h1>
            <ChartComponent data={data}/>
        </div>
    );
}

export default App;
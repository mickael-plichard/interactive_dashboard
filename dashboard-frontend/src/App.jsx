import { useQuery} from "@tanstack/react-query";
import ChartComponent from "../ChartComponent.jsx";

function App() {
    const { data, isLoading, error } = useQuery({
        queryKey: ["userDashboardData"],
        queryFn: () =>
            fetch("http://localhost:8000/api/dashboard")
                .then(res => res.json()),
    });

    if (isLoading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    return (
        <div style={{ padding: '20px' }}>
            <h1>Dashboard</h1>
            <ChartComponent data={data}/>
        </div>
    );
}

export default App;
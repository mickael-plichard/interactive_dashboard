import { useQuery} from "@tanstack/react-query";
import ChartComponent from "./ChartComponent.jsx";
import {useFilter} from "./context/FilterContext.jsx";

function App() {
    const { category, setCategory } = useFilter();
    const { data, isLoading, error } = useQuery({
        queryKey: ["dashboardData", category],
        queryFn: () =>
            fetch(`http://localhost:8080/api/dashboard${category ? `?category=${category}` : ''}`
            ).then(res => res.json()),
    });

    const handleFilterChange = (e) => {
        setCategory(e.target.value);
    };

    if (isLoading) return <div>Loading...</div>;
    if (error) return <div>Error: {error.message}</div>;

    return (
        <div style={{ padding: '20px' }}>
            <h1>Dashboard</h1>
            <div>
                <label>Filtrer par catégorie :</label>
                <select value={category} onChange={handleFilterChange}>
                    <option value="">Toutes</option>
                    <option value="Ventes">Ventes</option>
                    <option value="Utilisateurs">Utilisateurs</option>
                </select>
            </div>
            <ChartComponent data={data}/>
        </div>
    );
}

export default App;
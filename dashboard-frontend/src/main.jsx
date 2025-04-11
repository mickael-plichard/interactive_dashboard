import React from "react";
import ReactDOM from "react-dom";
import './index.css'
import App from './App.jsx'
import { QueryClient, QueryClientProvider} from '@tanstack/react-query'
import {FilterProvider} from "./context/FilterContext.jsx";

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById('root')).render(
<React.StrictMode>
    <QueryClientProvider client={queryClient}>
        <FilterProvider>
            <App/>
        </FilterProvider>
    </QueryClientProvider>
</React.StrictMode>
)

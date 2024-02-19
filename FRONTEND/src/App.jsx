import './App.css'
import { AppRouter } from './router/AppRouter'
import { DataMembersProvider } from "./context/DataMembers";

function App() {
  
  return (
    <>
    <DataMembersProvider>
      <AppRouter />
    </DataMembersProvider>
    </>
  )
}

export default App

import { createContext, useContext, useState, useEffect } from "react";


const DataMembersContext = createContext();


export const DataMembersProvider = ({ children }) => {
  const [Members, setMembers] = useState([]);
  const [needsReload, setNeedsReload] = useState(true);
  const URL = "http://localhost:9000/members";

  const fetchData = async (URL) => {
    try {
      const response = await fetch(URL);
      if (response.ok) {
        const data = await response.json();
        setMembers(data);
        setNeedsReload(false);
      } else {
        console.error("Error al obtener datos");
      }
    } catch (error) {
      console.error("Error de red", error);
    }
  };

  useEffect(() => {
    if (needsReload) {
      fetchData(URL);
    }
  }, [needsReload]);

  const value = {
    Members,
    needsReload,
    fetchData,
  };


  return <DataMembersContext.Provider value={value}>{children}</DataMembersContext.Provider>;
};



import { createContext, useContext, useState, useEffect } from "react";
import axios from "axios";

const DataMembersContext = createContext();

export const DataMembersProvider = ({ children }) => {
  const [members, setMembers] = useState([]);
  const [needsReload, setNeedsReload] = useState(true);
  const URL = "http://localhost:9000/members";

  const postMembers = async (newMember) => {
    try {
      const response = await axios.post(URL, newMember);

      if (response.status === 201) {
        console.log("Miembro agregado con éxito");
        setNeedsReload(true); 
      } else {
        console.error("Error al agregar miembro");
      }
    } catch (error) {
      console.error("Error de red", error);
    }
  };

  useEffect(() => {
    if (needsReload) {
      
      axios.get(URL)
        .then(response => {
          setMembers(response.data);
          setNeedsReload(false);  
        })
        .catch(error => {
          console.error("Error al obtener datos de miembros", error);
        });
    }
  }, [needsReload]);

  const value = {
    members,
    setMembers,
    needsReload,
    postMembers,
  };

  return <DataMembersContext.Provider value={value}>{children}</DataMembersContext.Provider>;
};

export const useDataMembers = () => {
  return useContext(DataMembersContext);
};
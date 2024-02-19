import { createContext, useContext, useState, useEffect } from "react";
import axios from "axios";

const DataMembersContext = createContext();

export const DataMembersProvider = ({ children }) => {
  const [members, setMembers] = useState([]);
  const [needsReload, setNeedsReload] = useState(true);
  const [searchTerm, setSearchTerm] = useState(""); // Nuevo estado para el término de búsqueda
  const URL = "http://localhost:9000/members";

  const postMembers = async (newMember) => {
    try {
      const response = await axios.post(URL, newMember);
      console.log(response);

      if (response.status === 201 || response.status === 200 || response.status === 204) {
        console.log("Miembro agregado con éxito");
        setNeedsReload(true);
        return response.data.idMembers; 
      } else {
        console.error("Error al agregar socio. Detalles:", response.data);
      }
    } catch (error) {
      console.error("Error de red", error);
      throw error;
    }
  };

  const searchMembers = () => {
    if (!searchTerm) {
      return members;
    }

    return members.filter(member =>
      member.name.toLowerCase().includes(searchTerm.toLowerCase())
    );
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
    members: searchMembers(), 
    setMembers,
    needsReload,
    postMembers,
    searchTerm,
    setSearchTerm,
  };

  return <DataMembersContext.Provider value={value}>{children}</DataMembersContext.Provider>;
};

export const useDataMembers = () => {
  return useContext(DataMembersContext);
};


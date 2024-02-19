
import { useDataMembers } from "../../context/DataMembers";
import PersonIcon from '@mui/icons-material/Person';
import './UsersSearcher.css';

export const UsersSearcher = () => {
  const { members, searchTerm, setSearchTerm } = useDataMembers();

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const filteredMembers = members.filter((member) =>
    member.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
    member.lastname.toLowerCase().includes(searchTerm.toLowerCase()) ||
    member.membershipNumber.toString().includes(searchTerm)
  );

  return (
    <section className="userSearchContainer">
      <div className='userSearchContainer__Field'>
        <div className="userButton">
          <PersonIcon className='userIcon' />
        </div>
      
        <input
          type="search"
          className="userSearchContainer__Field-Input"
          placeholder="Buscar socio por nombre, apellido, nº de socio"
          value={searchTerm}
          onChange={handleSearchChange}
        />
     <button className="userSearchContainer__Field-Button">
          <img src="/src/assets/searchIcon.svg" alt="búsqueda icono" />
        </button>        
      </div>
      
      {/* Puedes renderizar la lista de miembros filtrada aquí si es necesario */}
      <ul>
        {filteredMembers.map((member) => (
          <li key={member.id}>{member.name} {member.lastname} - Socio Nº: {member.membershipNumber}</li>
        ))}
      </ul>
    </section>
  )
}   


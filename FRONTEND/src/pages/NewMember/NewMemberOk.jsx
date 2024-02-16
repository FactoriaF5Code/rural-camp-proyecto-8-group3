import { SecondaryHeader } from "../../components/Header/SecondaryHeader"
import { NewMemberButton } from "../../components/NewMemberButton/NewMemberButton"
import { UsersSearcher } from "../../components/Searcher/UsersSearcher"
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import './NewMember.css'

export const NewMemberOk = () => {
  return (
    <>
      <SecondaryHeader />
      <section className="newMember">
        <UsersSearcher />
        <CheckCircleIcon className='newMember__checkIcon'/>
        <p className="newMember__alert">Usuario creado correctamente con nº de socio:</p>
        <p className="newMember__userNumber">123456</p>
        <NewMemberButton />
      </section>
    </>
  )
}

import { useEffect } from "react"
import { useParams } from "react-router-dom"

function StartQuiz() {
    const {category} = useParams()

    useEffect(async () => {
        const response = await fetch("http://localhost:8080/questions", {method: 'POST', headers: { 'Content-Type': 'application/json'}, body: JSON.stringify({ limit: '10', difficulty: '', category: category})})
        const data = await response.json()
        console.log(data)
    }, [])
    return <></>
}

export default StartQuiz

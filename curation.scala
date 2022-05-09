
import com.github.music.of.the.ainur.almaren.builder.Core.Implicit
import com.github.music.of.the.ainur.almaren.Almaren
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SaveMode

val almaren = Almaren("Demo")

val sourceDf=almaren.builder.sourceJdbc("jdbc:postgresql://w3.training5.modak.com/training_2021","org.postgresql.Driver","select * from mt3061.testartifact",Some("mt3061"),Some("mt3061@m07y21")).batch

almaren.builder
.sourceDataFrame(sourceDf).targetJdbc("jdbc:postgresql://w3.training5.modak.com/training_2021","org.postgresql.Driver", "mt3061.tablename", SaveMode.Overwrite, Some("mt3061"),Some("mt3061@m07y21"),Map("batchsize"->"5000")).batch

package sota.dto.response

/**
  * Response of {@link jota.dto.request.IotaNeighborsRequest}.
  **/
case class GetNodeInfoResponse(
                                appName: String,
                                appVersion: String,
                                jreVersion: String,
                                jreAvailableProcessors: Int,
                                jreFreeMemory: Long,
                                jreMaxMemory: Long,
                                jreTotalMemory: Long = 0L,
                                latestMilestone: String,
                                latestMilestoneIndex: Int,
                                latestSolidSubtangleMilestone: String,
                                latestSolidSubtangleMilestoneIndex: Int,
                                neighbors: Int,
                                packetsQueueSize: Int,
                                time: Long,
                                tips: Int,
                                transactionsToRequest: Int
                              )

